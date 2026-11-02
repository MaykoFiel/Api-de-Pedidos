 📦 API de Logística e Gestão de Pedidos

Uma API RESTful desenvolvida em Java e Spring Boot para automatizar o fluxo de criação, processamento e gestão de status de pedidos logísticos. O projeto conta com arquitetura baseada em DTOs, paginação de resultados, e integração com banco de dados relacional.

 🚀 Tecnologias Utilizadas

* Linguagem: Java 17+
* Framework:** Spring Boot 3
* Persistência e ORM Spring Data JPA / Hibernate
* Banco de Dados:** MySQL
* Validação:** Jakarta Bean Validation
* Gestão de Dependências: Maven

 ⚙️ Funcionalidades

* Cadastro de Pedidos:** Criação de novos pedidos com registro automático de data e hora (Timestamp).
* Listagem Paginada:** Retorno otimizado de pedidos, suportando grandes volumes de dados.
* Busca Específica:** Consulta detalhada de um pedido através do seu UUID único.
* Atualização de Status:** Endpoint seguro (`PATCH`) para atualizar a fase do pedido (ex: marcar como `PAGO`).
* Tratamento Global de Exceções:** Retornos de erro padronizados e amigáveis para falhas de validação ou pedidos não encontrados.
* Segurança e Isolamento:** Uso de Records (DTOs) para tráfego de dados, protegendo as entidades do banco.

 🔗 Endpoints da API

| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/pedidos` | Cria um novo pedido |
| `GET` | `/pedidos` | Retorna a lista de pedidos de forma paginada |
| `GET` | `/pedidos/{id}` | Retorna os detalhes de um pedido específico |
| `PATCH` | `/pedidos/{id}/pagar` | Atualiza o status do pedido para `PAGO` |

 🛠️ Como Executar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone [https://github.com/MaykoFiel/Api-de-Pedidos.git](https://github.com/MaykoFiel/Api-de-Pedidos.git)

   Configure as credenciais do seu banco de dados MySQL no ficheiro application.properties:

Properties

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha

👨‍💻 Autor
Desenvolvido por Mayko Fiel dos Anjos Santos

Engenharia de Software | Desenvolvedor Java Back-end

   
