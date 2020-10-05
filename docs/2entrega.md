# Sprint 2! [02/10/2020]

### Implementação de Jenkins 

### Gerenciador de logs do servidor 

### Software de monitoramento -Grafana 
#### Endpoints (Itens monitorados)
- [health] - Mostra informações de integridade do aplicativo (um status' simples quando acessado por uma conexão não autenticada ou detalhes completos da mensagem quando autenticado); não é sensível por padrão
- [info] – Exibe informações arbitrárias do aplicativo; não sensível por padrão
- [auditevents] – lista eventos relacionados à auditoria de segurança, como login/logout do usuário. Além disso, podemos filtrar por principal ou tipo, entre outros campos
- [beans] - r retorna todos os beans disponíveis em nosso BeanFactory. Ao contrário de /auditevents, ele não suporta filtragem
- [conditions] – anteriormente conhecido como/autoconfig, cria um relatório de condições em torno da configuração automática
- [configprops] – nos permite buscar todos os beans _ @ ConfigurationProperties_
- [env] – retorna as propriedades atuais do ambiente. Além disso, podemos recuperar propriedades únicas
- [flyway] – fornece detalhes sobre nossas migrações de banco de dados Flyway
- [heapdump] – constrói e retorna um dump de heap da JVM usada por nosso aplicativo
- [logfile] – retorna logs de aplicativos comuns
- [loggers] – nos permite consultar e modificar o nível de log do nosso aplicativo
- [metrics] – detalha as métricas de nosso aplicativo. Isso pode incluir métricas genéricas e personalizadas
- [prometheu]s – retorna métricas como a anterior, mas formatada para funcionar com um servidor Prometheus
- [scheduletasks] – fornece detalhes sobre todas as tarefas agendadas em nosso aplicativo
- [sessions] – lista as sessões HTTP, pois estamos usando o Spring Session
- [shutdown] – executa um desligamento normal do aplicativo */threaddump – despeja as informações de encadeamento da JVM subjacente

### Installation
Requisitos: [actuator].

