
-1- Details of the problem scenario and solution approach - https://medium.com/p/8a8b00b61263/edit
-2- Local Kafka setup -
   -a- download and install - https://www.tutorialspoint.com/apache_kafka/apache_kafka_installation_steps.htm
   -b- Zookeeper start cmd  - <Kafka_install_dir>\bin\windows\zookeeper-server-start.bat C:\Vijay\Java\apache-kafka\kafka_2.11-2.3.1\config\zookeeper.properties
   -c- Kafka-server start cmd - <Kafka_install_dir>\bin\windows\kafka-server-start.bat C:\Vijay\Java\apache-kafka\kafka_2.11-2.3.1\config\server.properties   
-3- Launch microservices
   -a- git clone in to your <project_dir> - git clone https://github.com/vijayredkar/event-driven-platform.git
   b- entity-mgt launch      - cd <project_dir>\event-driven-platform\entity-management >  mvn spring-boot:run
   c- customer-mgt launch    - cd <project_dir>\event-driven-platform\customer-management  mvn spring-boot:run
   d- account-mgt launch     - cd <project_dir>\event-driven-platform\account-management  mvn spring-boot:run
   e- monitoring-mgt launch  - cd <project_dir>\event-driven-platform\supporting\monitoring-svc  mvn spring-boot:run
   g- notification-mgt launch - cd <project_dir>\event-driven-platform\supporting\notification-svc  mvn spring-boot:run
   h- recommendation-mgt launch - cd <project_dir>\event-driven-platform\supporting\recommendation-svc  mvn spring-boot:run
 4- Test - sample cURL - event-initiator-new.txt
 5- Output verification

