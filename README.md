# Avaliation System ECommerce

## Description

- Este projeto é um micro-serviço de avaliação de produtos de um e-commerce.
- A função deste micro-serviço é garantir a integridade das avaliações dos produtos, alta disponibilidade dos dados e do sistema.
- O sistema deve ser capaz de lidar com um grande volume de avaliações e usuários simultâneos.

## Sobre o Projeto

### O que eu espero Aprender com este projeto?

- [x] Docker -> O aprendizado obtido veio através de conteiners que precisei criar e gerenciar para atingir os objetivos da aplicação.
- [ ] Kubernetes -> Ainda não consegui implementar o kubernetes, mas pretendo implementar em breve.
- [x] Conseguir criar um sistema de Cache -> Utilizei o Redis para armazenar os dados de avaliação e a interface do spring boot Cache.
- [x] Paginação -> Utilizei o Pageable do Spring Data JPA para realizar a paginação dos dados.
- [X] Criar e integrar com mensageria -> Utilizei o SQS para salvar as avaliações em que houve erro de processamento, como por exemplo em um cenário onde meu banco ficou indisponível.
- [x] Criar um sistema de logs -> Utilizei a interface do Slf4j do lombok para criar logs de informações, erros e debug.
- [x] Criar um sistema de Observabilidade -> Consegui exportas as metricas com actuator e o prometheus e gerenciei dashboards via grafana.

### Rodando o projeto

Após clonar o projeto recomendo usar o do clean install do maven, como abaixo.

```bash
mvn clean install
```

Após instalado todas as dependências basta pedir a sua IDE que rode o projeto.

![image](https://github.com/Catrofe/api-parcelamento/assets/82066310/535d01f5-9a09-47dc-b656-cb42668cf653)

Para facilitar com as chamadas implementei o Open-API swagger.

```bash
http://localhost:8080/swagger-ui/index.html
```
