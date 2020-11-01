FROM maven:3.6.3-jdk-8-slim
		
WORKDIR /heatclinic

COPY . /heatclinic/

COPY start_heatclinic.sh /heatclinic/

RUN chmod +x start_heatclinic.sh

RUN mvn clean install -Dmaven.test.skip=true

EXPOSE 8443	
EXPOSE 8080
EXPOSE 9001
EXPOSE 8983

ENTRYPOINT ["./start_heatclinic.sh"]

