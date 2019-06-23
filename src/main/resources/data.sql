insert into plan(id_plan, name, price, description, min_age, min_income)
values (1, 'PlanA', 500000, 'Kamar Rawat Inap = 500.000/hari, Biaya Perawatan Rawat Inap = 75.000.000/Tahun, Biaya Rawat Jalan = 75.000.000/Tahun', 17, 5000000),
       (2, 'PlanB', 700000, 'Kamar Rawat Inap = 750.000/hari, Biaya Perawatan Rawat Inap = 100.000.000/Tahun, Biaya Rawat Jalan = 100.000.000/Tahun', 35, 7000000),
       (3, 'PlanC', 1000000, 'Kamar Rawat Inap = 1000.000/hari, Biaya Perawatan Rawat Inap = 120.000.000/Tahun, Biaya Rawat Jalan = 120.000.000/Tahun', 55, 10000000),
       (4, 'PlanD', 1500000, 'Kamar Rawat Inap = 1.500.000/hari, Biaya Perawatan Rawat Inap = 150.0000.000/Tahun, Biaya Rawat Jalan = 150.000.000/Tahun', 65, 15000000);

insert into user(id_user, name, sex, birth_date, income, phone_number, job_type, smoking_status, plan)
values (1, 'marwan', 'M', '1982-02-02', 5000000, '+62821321321', '1', 1, 1),
       (2, 'marvel denver', 'F', '1981-01-01', 5000000, 4324432334, 2, '0', 2);