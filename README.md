# ARQUITETURA HEXAGONAL

##  O que é a Arquitetura Hexagonal?

A arquitetura hexagonal, criada por Alistair Cockburn, é um estilo arquitetural que tem um objetivo principal:

- Isolar o núcleo da aplicação (regras de negócio) das partes externas (banco, API, framework, etc.)

Ou seja:

O core deve ser totalmente independente de qualquer tecnologia.
Quem depende de quem são os frameworks, não o core.

Ela é organizada em 3 camadas lógicas:

## 1. Core Domain

(Entidades, regras de negócio, Value Objects)

É a parte mais pura do sistema.
Não tem Spring, não tem annotations, não tem HTTP, não tem JSON, não tem JPA.

Exemplo:

- Pedido, Cliente, Produto

- Regras de validação

- Cálculo de preço

- Políticas do negócio

## 2. Application / Use Cases

(Orquestra o domínio — mas sem tecnologia)

Essa camada coordena o fluxo:

Recebe comandos (inputs)

Usa o domínio

Chama repositórios (através de interfaces)

Aplica regras de casos de uso

Aqui ficam:

- Use cases

- Input ports

- Output ports (interfaces de repositório, mensageria etc.)

Ainda não tem framework aqui.

## 3. Adapters / Infrastructure

(Concreto, dependente de tecnologia)

Tudo aquilo que "pluga" no core:

Tipo de Adapter	Exemplos
Driver (Entrada)	Controllers REST, CLI, Eventos, gRPC
Driven (Saída)	Banco (JPA), Kafka, RabbitMQ, APIs externas

Aqui sim mora o Spring, JSON, HTTP, JPA, JDBC, etc.

### 🔌 Ports

São interfaces que definem o contrato entre o core e o mundo externo.

Existem dois tipos:

#### 1. Input Port

Interface que os adapters de entrada chamam para executar um caso de uso.

#### 2. Output Port

Interface que o core usa para chamar algo externo (ex: salvar no banco).

# 🧠 Por que o nome “hexagonal”?

É apenas uma metáfora:

cada lado do hexágono representa um “port”

cada port pode ser conectado (adaptado) por diferentes tecnologias

O nome real é:

- Ports and Adapters Architecture

O motivo principal da arquitetura
Desacoplamento total do core

O domínio não conhece:

- Spring

- Banco de dados

- Frameworks

- HTTP

- Filas

- Segurança

- Cloud

- Libraries

Isso dá:

- ✔ Testes mais fáceis (sem mockar framework)
- ✔ Independência de framework
- ✔ Fácil trocar infraestrutura (JPA → JDBC → Mongo)
- ✔ Domínio mais limpo e expressivo
- ✔ Zero dependência externa