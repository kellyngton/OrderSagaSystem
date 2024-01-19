# Projeto Prático - Implementação de Microsserviços com Padrão Saga

## Introdução
Bem-vindo ao meu projeto prático, resultado do aprendizado adquirido no curso "Microsserviços com Padrão Saga Orquestrado e Coreografado". Aqui, compartilho minha jornada na implementação de uma arquitetura de microsserviços robusta, utilizando os conceitos e práticas ensinados no curso.

## Visão Geral
O objetivo principal deste projeto é desenvolver uma arquitetura de microsserviços capaz de lidar eficientemente com transações distribuídas e tratamento de falhas. Para isso, baseei-me nos tópicos chave abordados no curso, enfatizando a aplicação do padrão Saga Orquestrado.

## Tecnologias Utilizadas
- Java 17 e Spring Boot 3: Para a implementação prática do padrão Saga Orquestrado nos microsserviços.
- Docker e docker-compose: Facilitando a gestão do ambiente de desenvolvimento e deploy da arquitetura.
- Bancos de dados:
  - PostgreSQL e MongoDB: Utilizados conforme as necessidades específicas de cada microsserviço.
- Apache Kafka: Para a comunicação de eventos e orquestração da saga.

## Estrutura do Projeto
A arquitetura é composta por cinco APIs, cada uma desempenhando um papel específico na saga:
1. **Orquestrador:** Responsável por coordenar a execução da saga.
2. **Microsserviço de Pedido:** Encarregado da realização do pedido.
3. **Microsserviço Participante 1-3:** Três microsserviços colaboradores na execução da saga.

## Aprendizados Obtidos
Ao concluir este projeto, alcancei uma compreensão aprofundada dos seguintes tópicos:
- Conceitos fundamentais de transações distribuídas.
- Estratégias para tratamento de falhas em microsserviços.
- Implementação prática do padrão Saga Orquestrado e Coreografado.
- Uso efetivo de Docker para gerenciamento do ambiente de desenvolvimento.
- Trabalho com bancos de dados PostgreSQL e MongoDB em uma arquitetura de microsserviços.
- Boas práticas na implementação de padrões em microsserviços.
- Desenvolvimento de aplicações distribuídas com orientação a eventos usando Apache Kafka.
