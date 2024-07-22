# Agencia Vuelos Globales

## Introducción

En el mundo actual, el desarrollo de software es fundamental para el funcionamiento eficiente y seguro de una aerolínea. La tecnología ha revolucionado la forma en que las aerolíneas operan, desde la gestión de vuelos y el mantenimiento de aeronaves hasta la experiencia del cliente. En una industria donde la puntualidad, la seguridad y la satisfacción del cliente son cruciales, el software se convierte en un aliado indispensable.

Vuelos Globales opera vuelos a nivel internacional y cuenta con una flota de aviones, tripulación variada, múltiples aerolíneas asociadas y una vasta red de aeropuertos y ciudades de destino. La empresa requiere una base de datos robusta para gestionar todos los aspectos de su operación, desde la reserva de vuelos hasta el mantenimiento de los aviones y la administración de la tripulación.

## Tabla de Contenidos
- [Características](#características)
- [Documentación](#documentación)
- [Tecnologías Usadas](#tecnologías-usadas)
- [Estructura del Proyecto](#estructura-del-proyecto)
- [Contribución](#contribución)
- [Autores](#autores)

### Requisitos Previos
- Java JDK 17.0+
- MySQL 8.0+
- Maven 4.0.0

### Pasos para la Instalación
1. Clona el repositorio:
   ```bash
   git clone https://github.com/Maricifu/AgenciaVuelosGlobales.git
   ```
2. Crea y navega al directorio del proyecto:
    ```bash
    cd agencia-vuelos-globales
    ```

## Características
- Gestión de aviones y modelos
- Mantenimiento y revisiones de aeronaves
- Administración de tripulación
- Gestión de rutas y escalas
- Sistema de reservas y clientes
- Tarifas y tipos de documentos

## Documentación
Para más detalles, visita la [documentación](/docs/).

## Tecnologías Usadas
- **Lenguaje de Programación:** Java
- **Base de Datos:** MySQL
- **Control de Versiones:** Git


## Estructura del Proyecto 
```css
📦src
 ┗ 📂main
 ┃ ┗ 📂java
 ┃ ┃ ┣ 📂com
 ┃ ┃ ┃ ┗ 📂vuelos
 ┃ ┃ ┃ ┃ ┣ 📂Airline
 ┃ ┃ ┃ ┃ ┃ ┗ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Airline.java
 ┃ ┃ ┃ ┃ ┣ 📂Plane
 ┃ ┃ ┃ ┃ ┃ ┣ 📂application
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CreatePlaneUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜DeletePlaneUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FindAllPlanesUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜FindPlaneByIdUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UpdatePlaneUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Plane.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂services
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PlaneService.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂infrastructure
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂in
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PlaneController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂out
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PlaneRepository.java
 ┃ ┃ ┃ ┃ ┣ 📂PlaneModel
 ┃ ┃ ┃ ┃ ┃ ┗ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Model.java
 ┃ ┃ ┃ ┃ ┣ 📂Status
 ┃ ┃ ┃ ┃ ┃ ┗ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜Status.java
 ┃ ┃ ┃ ┃ ┣ 📂User
 ┃ ┃ ┃ ┃ ┃ ┣ 📂application
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜CreateUserUseCase.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂domain
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂entity
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Permission.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Role.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜User.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📂infrastructure
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂in
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂out
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PermissionRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜RoleRepository.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserRepository.java
 ┃ ┃ ┃ ┃ ┗ 📜Main.java
 ┃ ┃ ┗ 📂config
 ┃ ┃ ┃ ┗ 📜DatabaseConfig.java
 ┃ ┃ ┃ ┗ 📜SecurityManager.java
```

```css
agencia-vuelos-globales/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/        
│   │   │   │   ├── service/       
│   │   │   │   └── dto/          
│   │   │   ├── domain/           
│   │   │   │   ├── model/         
│   │   │   │   ├── repository/    
│   │   │   │   └── service/      
│   │   │   └── infrastructure/    
│   │   │       ├── adapter/      
│   │   │       │   ├── web/       
│   │   │       │   └── persistence/ 
│   │   │       └── config/        
│   │   │   
│   │   └── resources/          
│   └── test/                    
│       └── java/
│           └── application/
│               └── service/
├── scripts/
│   └── sql/
│       ├── create_tables.sql      
│       └── insert_data.sql        
├── pom.xml                        
└── README.md    
```

## Contribución

Para contribuir, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (git checkout -b feature/nueva-funcionalidad).
3. Realiza tus cambios y haz commit (git commit -am 'Añadir nueva funcionalidad').
4. Sube tu rama (git push origin feature/nueva-funcionalidad).
5. Abre un Pull Request.

## Autores 

- Mariana Cifuentes Ramírez *- Developer* .  <a href="http://github.com/Maricifu" target="_blank">MariCifu</a>
- Elkin Gabriel Niño Sánchez  *- Developer* . <a href="https://github.com/Latinohablante" target="_blank">Latinohablante</a>
