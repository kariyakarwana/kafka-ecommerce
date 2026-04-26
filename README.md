# Kafka E-Commerce Microservices System - ETC - CA03

## Project Overview

This project is an event-driven e-commerce order processing system developed for Continuous Assignment 03: Industrializing Intelligence - The 15-Factor App Audit.

The system demonstrates how Apache Kafka can be used to reduce tight coupling between microservices by enabling asynchronous event-based communication. The main business flow includes order creation, payment processing, inventory update, and customer notification.

## Technology Used

- Java 17
- Spring Boot
- Apache Kafka
- Docker
- Docker Compose
- Maven
- REST API
- Event-Driven Architecture

## Microservices

The system contains four main microservices:

| Service | Port | Responsibility |
|---|---:|---|
| Order Service | 8081 | Accepts customer order requests and publishes `order_created` events |
| Payment Service | 8082 | Consumes `order_created` events and publishes `payment_processed` events |
| Inventory Service | 8083 | Consumes `payment_processed` events and publishes `inventory_updated` events |
| Notification Service | 8084 | Consumes `inventory_updated` events and sends notification logs |

## Kafka Topics

| Topic Name | Producer | Consumer |
|---|---|---|
| `order_created` | Order Service | Payment Service |
| `payment_processed` | Payment Service | Inventory Service |
| `inventory_updated` | Inventory Service | Notification Service |

## System Flow

Client / Postman
      |
      v
Order Service
      |
      v
Kafka Topic: order_created
      |
      v
Payment Service
      |
      v
Kafka Topic: payment_processed
      |
      v
Inventory Service
      |
      v
Kafka Topic: inventory_updated
      |
      v
Notification Service

##Folder Structure

kafka-ecommerce/
│
├── docker-compose.yml
├── README.md
│
├── order-service/
├── payment-service/
├── inventory-service/
└── notification-service/

##How to Run the Project
1. Clone the Repository
git clone https://github.com/kariyakarwana/kafka-ecommerce.git
cd kafka-ecommerce
2. Start All Services
docker compose up --build

##This command starts:

Apache Kafka
Order Service
Payment Service
Inventory Service
Notification Service
API Testing

Use Postman or any REST client.

Create Order
POST http://localhost:8081/orders
Request Body
{
  "customerId": "C001",
  "productId": "P001",
  "quantity": 2,
  "amount": 4500.00
}
Expected Response
{
  "message": "Order created successfully",
  "orderId": "generated-order-id"
}
Expected Console Logs

After creating an order, the event flow should be visible in Docker logs.

ORDER SERVICE: Published order_created event
PAYMENT SERVICE: Received order_created event
PAYMENT SERVICE: Published payment_processed event
INVENTORY SERVICE: Received payment_processed event
INVENTORY SERVICE: Published inventory_updated event
NOTIFICATION SERVICE: Notification sent for order
15-Factor App Audit Summary

This project was evaluated using the 15-Factor App methodology.

Factor	Status
One Codebase, One Application	Partially Considered
API First	Partially Considered
Dependency Management	Partially Considered
Design, Build, Release, Run	Partially Considered
Configuration, Credentials, Code	Partially Considered
Logs	Partially Considered
Disposability	Partially Considered
Backing Services	Fully Considered
Environment Parity	Partially Considered
Administrative Processes	Partially Considered
Port Binding	Fully Considered
Stateless Processes	Partially Considered
Concurrency	Partially Considered
Telemetry	Not Considered
Authentication and Authorization	Partially Considered
Authentication and Authorization Gap

The current Kafka setup uses plaintext communication:

KAFKA_LISTENERS: PLAINTEXT://:9092,CONTROLLER://:9093
KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
KAFKA_LISTENER_SECURITY_PROTOCOL_MAP: CONTROLLER:PLAINTEXT,PLAINTEXT:PLAINTEXT

This means SSL encryption, SASL authentication, and ACL-based authorization are not implemented in the current prototype.

For production deployment, the system should include:

SSL/TLS encryption
SASL authentication
Kafka ACL authorization
JWT authentication for REST endpoints
Secure secret management using Kubernetes Secrets or Vault
Industrialization Roadmap

Future improvements include:

Add CI/CD pipeline using GitHub Actions
Add AsyncAPI documentation for Kafka events
Add centralized logging using ELK or Grafana Loki
Add Prometheus and Grafana monitoring
Enable Kafka SSL, SASL, and ACL security
Deploy services to Kubernetes
Add database persistence for order, payment, and inventory records
Add retry and dead-letter queue mechanisms for failed events
Screenshots for Assignment Evidence


M.K. Sandaruwan
Bachelor of Science (Hons.) in Software Engineering
General Sir John Kotelawala Defence University

Assignment

Emerging Trends of Computing
Continuous Assignment 03: Industrializing Intelligence - The 15-Factor App Audit
