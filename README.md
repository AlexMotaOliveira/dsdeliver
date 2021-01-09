## Projeto realizado na 2ª Semana do DEV Superior, constrindo uma API Rest DSDelivery com SpringBoot.

Para acessar todo o conteúdo da SDS2 <a href= https://github.com/devsuperior/sds2>clique aqui</a>

### Backend

* Java 1.8 ou superiror
* Gradle
* SpringBoot
    * Spring Data JPA
    * Spring Web
    * Postgres
    * H2
    * Lombok
    * Mapstruct
    
### Modelo conceitual

![img.png](img.png)

### Padrão de camadas

![img_1.png](img_1.png)


### Endpoints

Projeto hospedado em http://alexmotaoliveira.com/dsdeliver

[GET] http://alexmotaoliveira.com/dsdeliver/products

[GET] http://alexmotaoliveira.com/dsdeliver/orders

[POST] http://alexmotaoliveira.com/dsdeliver/orders

[PUT] http://alexmotaoliveira.com/dsdeliver/orders/{id}/delivered