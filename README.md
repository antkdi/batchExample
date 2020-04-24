<div align="center">
<h1>Spring-Batch Application</h1>
</div>

- [1.Subject](#1subject)
- [2.Environment](#2environment)
- [3.Install](#3install)
- [4. Usage](#4usage)



## 1.Subject 

Spring-batch 를 사용하여 배치 프로그램 작성

    - Task 작성
    - Tasklet 작성
    - Task에 대한 Linstener 작성
    - JDBC를 이용한 Task 작성
    - 여러 라인의 스트럭처로 구성된 Multiple File ItemReader 작성



 ## 2.Environment 

  - JDK 1.8
  - InteliJ
  - Gradle 4.10.3
  - lombok 1.18.6
  - Spring boot 2.2.2.RELEASE
  - Spring-batch



 ## 3.Install 

  - Repository Clone

    - `$ git clone https://github.com/antkdi/batchExample`

    

## 4.Usage

  - Build

    - `$ ./gradlew bootJar`

  - Execute

    - `$ java -jar ./build/libs/batch-example.jar`

    

