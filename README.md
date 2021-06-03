1. Problem statement & solution approach - https://vijayredkar.medium.com/
2. Architecture diagram - ![BankNext_Choreography_Arch](https://user-images.githubusercontent.com/25388646/120706277-bd386080-c46d-11eb-98c8-7e2637750786.png)

3. Local Kafka setup
    - download and install - https://www.tutorialspoint.com/apache_kafka/apache_kafka_installation_steps.htm
    - Zookeeper start cmd  - <Kafka_install_dir>\bin\windows\zookeeper-server-start.bat <Kafka_install_dir>\config\zookeeper.properties
    - Kafka-server start cmd - <Kafka_install_dir>\bin\windows\kafka-server-start.bat <Kafka_install_dir>\config\server.properties
4. Launch microservices
   - git clone in to your 
     - <project_dir> - git clone https://github.com/vijayredkar/event-driven-platform.git
   #### core services
   - entity-mgt launch      
     - cd <project_dir>\event-driven-platform\entity-management >  mvn spring-boot:run
   - customer-mgt launch    
     - cd <project_dir>\event-driven-platform\customer-management >  mvn spring-boot:run
   - account-mgt launch     
     - cd <project_dir>\event-driven-platform\account-management >  mvn spring-boot:run   
   #### prechecks services
   - screening-svc launch     
     - cd <project_dir>\event-driven-platform\prechecks\screening-svc >  mvn spring-boot:run   
   - deduplication-svc launch     
     - cd <project_dir>\event-driven-platform\prechecks\deduplication-svc >  mvn spring-boot:run
   #### supporting services
   - monitoring-mgt launch  
     - cd <project_dir>\event-driven-platform\supporting\monitoring-svc >  mvn spring-boot:run
   - notification-mgt launch  
     - cd <project_dir>\event-driven-platform\supporting\notification-svc >  mvn spring-boot:run
   - recommendation-mgt launch 
     - cd <project_dir>\event-driven-platform\supporting\recommendation-svc >  mvn spring-boot:run
   4. Sample test cURL
   - https://github.com/vijayredkar/event-driven-platform/blob/main/entity-management/src/test/cURL_event-initiator-new.txt
