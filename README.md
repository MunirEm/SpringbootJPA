# 🏨 InterfazBoot – Gestión de Hoteles y Empleados (Spring Boot + Swing)

Este proyecto es propio para fines educativos, es una aplicación Java de escritorio desarrollada con **Swing** e integrada con **Spring Boot y Spring Data JPA** para la gestión de **Hoteles** y **Empleados** con una relación bidireccional 1:1.

---

## ✨ Funcionalidades

- ✅ Insertar hoteles (ciudad, país, estrellas)
- ✅ Insertar empleados (DNI, nombre, apellidos, salario, categoría)
- ✅ Asociar un hotel con sus empleados (relación 1:1 bidireccional)
- ✅ Consultas:
  - Hoteles en España con más de 3 estrellas
  - Empleados por ciudad
  - Empleados por categoría y rango salarial (estructura incompleta)

---

## 🛠️ Tecnologías usadas

- Java 17+ (compatible con Java 8+ si se ajusta el `pom.xml`)
- Swing (GUI)
- Spring Boot
- Spring Data JPA
- H2 Database (o puedes usar MySQL, PostgreSQL, etc.)
- Maven

---

## 🏗️ Estructura del proyecto

InterfazBoot/
├── src/main/java/bootJPA/
│ ├── InterfazBoot.java ← clase principal (GUI + Spring Boot)
│ ├── Empleados.java ← entidad JPA
│ ├── Hoteles.java ← entidad JPA
│ ├── EmpleadosRepo.java ← repositorio de empleados
│ ├── HotelesRepo.java ← repositorio de hoteles
├── src/main/resources/
│ ├── application.properties ← configuración de base de datos
├── pom.xml ← dependencias y configuración Maven



## 🚀 Cómo ejecutar el proyecto

### 📦 Requisitos

- Eclipse (con soporte Maven) o IntelliJ
- JDK 17 o compatible
- Git y Maven instalados

### 🔧 Pasos

1. Clona el repositorio:

   ```bash
   git clone https://github.com/MunirEm/SpringbootJPA.git
   cd SpringbootJPA
Abre el proyecto en Eclipse como "Proyecto Maven existente".

Revisa application.properties para usar H2:

properties

spring.datasource.url=jdbc:h2:mem:testdb

spring.datasource.driverClassName=org.h2.Driver

spring.datasource.username=sa

spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

spring.h2.console.enabled=true

Ejecuta InterfazBoot.java como aplicación Java.

🧪 Notas técnicas
Las operaciones están ligadas a botones en la interfaz Swing.

La inyección de repositorios se realiza mediante @Autowired.

La base de datos puede ser H2 o cualquier JPA-compatible.

Usa @EntityScan, @EnableJpaRepositories y @EnableTransactionManagement.
