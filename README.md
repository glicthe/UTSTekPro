# **Exam of Teknik pemrograman**
## About this code:
A complete solution of the given task, using **`java`** and basic `OOP` about `class`, `method`, `inheritance`, and other basic `OOP`\
the task is about making a pay slip, plus the allowance given in a specific condition. 

## **What is the task?**
**Provisions for calculating employee salaries:**\
 **1.** `Fulltime` salary: Basic salary + overtime allowance + position allowance + child support + communication allowance + productivity bonus + project bonus - cooperative loan\
 **2.** `Parttime` salary: Basic salary + overtime allowance + project bonus
 
\
 **Basic Salary Conditions (By position level & length of service):**
 **Position** | **Basic Salary** (0-2 years) | **Basic Salary** (3-5 years) | **Basic Salary** (>5 years)
--- | --- | --- | --- 
**_Staff Manager_** | Rp5.000.000 | Rp6.000.000 | Rp7.000.000 
**_Staff Programmer_** | Rp3.000.000 | Rp4.000.000 | Rp5.000.000 
**_Staff Analis_** | Rp3.000.000 | Rp3.500.000 | Rp4.500.000 

\
**Position Allowance Conditions (Given if already worked for at least 3 years):**
 **Position** | **Position Allowance** 
--- | --- 
**_Staff Manager_** | Rp5.000.000  
**_Staff Programmer_** | Rp2.000.000  
**_Staff Analis_** | Rp3.000.000  

\
**Other Allowance Comditions:**
  1. _**Communication Allowance**_: Rp500.000 (for all position level).
  2. _**Overtime Allowance**_: Rp30.000/Hour on weekdays, Rp50.000/Hour on Sunday/Saturday.
  3. _**Child Support**_: Maximum 3 children, Rp500.000/Child.
  4. _**Productivity Bonus**_: If the employee works more than 200 hours in a month, then get 10% bonus from their basic salary.
  5. _**Project Bonus**_: For Parttime employee, each finished project get a bonus for Rp200.000.

\
**Pay Date and Pay slip Conditions:**
  1. Pay slip published every 1st date of next month (example: March pay slip published on 1st april).
  2. Salary paid every 1st date of next month (Example: March salary paid on 1st april).
  3. If the payday falls on saturday/sunday or public holiday, then salary payments are made on the previous working day.

\
**Calculated Employee Conditions:**
* **Asep** is a Fulltime Staff Programmer, working since January 1, 2021. has 2 children, has a cooperative loan of Rp500.000/Month.
  * On March 15th (Saturday), **Asep** overtime from `09:00` to `12:00`.
  * On March 16th (Sunday), **Asep** overtime from `20:00` to `23:00`.
* **Ujang** is a Parttime Staff Programmer, not married, working since January 1, 2024. and on march 25, 2025 the current project was completed.
  * On March 15th (Saturday), **Ujang** overtime from `03:00` to `18:00`.
  * On March 16th (Sunday), **Ujang** overtime from `10:00` to `14:00`.

### **Format for the Pay Slip:**
=======Slip Gaji Bulan Maret=======\
Tanggal Terbit          : 1 April 2025\
Tanggal Pembayaran      : 1 April 2025

\
Nama                    : `.....`\
Jabatan                 : `.....`\
Total Jam Kerja         : `x` Jam\
Total Lembur            : `x` Jam\
Total Tunjangan ....... : Rp`.....`\
Total Pinjaman Koperasi : Rp`.....`
> _**Note**: Cooperative loan and other allowance only for Fulltime_

Total Gaji              : Rp`.....`


## MY Result:
[Asep's Result](ResultAsep.png)


[Ujang's Result](ResultUjang.png)


