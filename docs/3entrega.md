# Planner

https://docs.google.com/spreadsheets/d/1TkCrRUHple8hmNI0jp1qU20dUsHuNtXHd2m8KdDF88I/edit#gid=0

## Sprint 3 

Detalhar as atividades realizadas:

- Deploy (AWS) (DevOps)
  - Foram criadas as maquinas no E2 AWS e configurada aplicação.
<h1 align="center">
    <img alt="GoBarber" src="/imagem/AWS-Deploy.png" />
</h1>

- Gerenciador de pipeline (DevOps)

- Configuração Docker (Preparação do ambiente)(DevOps)
  - O Pacote Docker foi criado e testado para subir com a aplicação se a necessidade de demais configurações no ambiente:
  - Arquivo DockerFile
  
  ```bash
  FROM openjdk:11
  ARG PROFILE
  ARG ADDITIONAL_OPTS

  ENV PROFILE=${PROFILE}
  ENV ADDITIONAL_OPTS=${ADDITIONAL_OPTS}

  WORKDIR /opt/spring_boot

  COPY /target/spring-boot*.jar spring_boot_produtora.jar

  SHELL ["/bin/sh", "-c"]

  EXPOSE 5005
  EXPOSE 8080

  CMD java ${ADDITIONAL_OPTS} -jar spring_boot_produtora.jar --spring.profiles.active=${PROFILE}
  ```


- Segurança por token com JWT (Back-end) 
  - Atividade realizada no Back-end
