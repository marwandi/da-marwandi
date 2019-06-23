package com.da.commit.insurance.service.impl;

import com.da.commit.insurance.dto.PremiDTO;
import com.da.commit.insurance.entity.Plan;
import com.da.commit.insurance.entity.User;
import com.da.commit.insurance.exception.UserNotFoundException;
import com.da.commit.insurance.repository.PlanRepository;
import com.da.commit.insurance.repository.PremiRepository;
import com.da.commit.insurance.repository.UserRepository;
import com.da.commit.insurance.service.PremiService;
import com.da.commit.insurance.util.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

/**
 * This class is to process PremiService related to request from PremiController
 */
@Slf4j
@Service
public class PremiServiceImpl implements PremiService {

    @Autowired
    PlanRepository planRepository;

    @Autowired
    PremiRepository premiRepository;

    @Autowired
    UserRepository userRepository;

    Response response = Response.builder().build();

    public Response<PremiDTO> getPremi(PremiDTO premiDTO) throws UserNotFoundException{

        Integer idUser = premiDTO.getIdUser();
        User user = userRepository.findByIdUser(idUser);

        if(user == null) {
            throw new UserNotFoundException("Invalid User ID");
        }
        daftarPlan(user, premiDTO);

        Optional<Plan> optionalPlan = planRepository.findById(premiDTO.getIdPlan());

        Plan plan = optionalPlan.get();

        BigDecimal totalPremi = jobType(user, plan);

        response.setData(totalPremi);
        response.setResponseCode(HttpStatus.OK.toString());
        response.setResponseMessage("Success");

        return response;
    }

    /**
     * for validate register paket
     * @param user for call entity user
     * @param premiDTO for call premiDTO
     * @throws UserNotFoundException for handling UserNotFoundException
     */

    public void daftarPlan(User user, PremiDTO premiDTO) throws UserNotFoundException {
        Long date = new Date().getTime() - (user.getBirthDate().getTime());
        Long age = date / 31536000000L;
        log.info(age.toString());

        user.setPlan(premiDTO.getIdPlan());

        switch (premiDTO.getIdPlan()) {
            case 1:
                if(user.getIncome() >= 5000000 && age >= 17) {
                    userRepository.save(user);
                }
                break;
            case 2:
                if(user.getIncome() >= 7000000 && age >= 35L){
                    userRepository.save(user);
                }
                break;
            case 3:
                if(user.getIncome() >= 10000000 && age >= 55L){
                    userRepository.save(user);
                }
                break;
            default:
                if(user.getIncome() >= 15000000 && age >= 65L){
                    userRepository.save(user);
                }
                else throw new UserNotFoundException("Invalid Plan");
                break;
        }

    }

    /**
     * for checking smoking and Job pinalty
     * @param user for call entity user
     * @param plan for call entity plan
     * @return totalpremi
     * @throws UserNotFoundException for handling UserNotFoundException
     */
    public BigDecimal jobType(User user, Plan plan) throws UserNotFoundException {
        BigDecimal jobTypePremi;
        BigDecimal subPremi;
        BigDecimal totalPremi;
        BigDecimal smokingPremi;

        /**
         cek penalti smoking
         */
        if ("1".equals(user.getSmokingStatus())) {
            smokingPremi = plan.getPrice().multiply(BigDecimal.valueOf(0.01));

        } else if ("0".equals(user.getSmokingStatus())) {
            smokingPremi = plan.getPrice();
        } else {
            throw new UserNotFoundException("");
        }

        /**
        cek Job Type
         */

        switch (user.getJobType()) {
            case "1":
                jobTypePremi = plan.getPrice().multiply(BigDecimal.valueOf(0.01));
                break;
            case "2":
                jobTypePremi = plan.getPrice().multiply(BigDecimal.valueOf(0.005));
                break;
            default:
                throw new UserNotFoundException("");
        }

        subPremi = smokingPremi.add(jobTypePremi);
        totalPremi = subPremi.add(plan.getPrice());

        return totalPremi;

    }


    }
