# Product Service (Тестовое задание в H2O)

## Запуск
- ### Запуск через Docker

``` docker compose up --build ```


- ### Запуск локально

Создать базу данных `h2o_test_db` в postgresql

В `application.yml` указать свои данные для подключения:
```
spring:  
  datasource:  
    url: ${SPRING_DATASOURCE_URL:jdbc:postgresql://localhost:5432/h2o_test_db}  
    username: ${SPRING_DATASOURCE_USERNAME:postgres}  
    password: ${SPRING_DATASOURCE_PASSWORD:postgres}

```
запуск 
```
./gradlew bootRun
```

---

## После запуска:
api: [http://localhost:8080]()

swagger ui: http://localhost:8080/swagger-ui/index.html

---
## Эндпоинты

- ### Создание товара 
    POST [/product]()

Запрос:
```json
{
  // в зависимости от типа создаваемого продукта: COMPUTER, HARD_DRIVE, LAPTOP, MONITOR
  "type": "COMPUTER",  

  // универсальные поля
  "serialNumber": "string",
  "manufacturer": "string",
  "price": 0,      // price > 0
  "quantity": 0,   // quantity >= 0
  
  // поля специфичные для определенного продукта (выбрать нужное)
  
  // для COMPUTER. Допустимые значения: NETTOP, MONOBLOCK, DESKTOP
  "formFactor": "DESKTOP", 
  
  // для HARD_DRIVE. capacityGb > 0
  "capacityGb": 0,
  
  // для MONITOR. diagonal >= 0.1 и один символ после запятой
  "diagonal": 0.1, 
  
  // для LAPTOP. Допустимые значения: INCH_13, INCH_14, INCH_15, INCH_17
  "size": "INCH_13" 
}
```

---

- ### Редактирование товара 
    PATCH [/product/{id}]()

Запрос:
```json
{
  "serialNumber": "string",
  "manufacturer": "string",
  "price": 100,
  "quantity": 2,
  "formFactor": "DESKTOP",
  "capacityGb": 512,
  "diagonal": 15.6,
  "size": "INCH_13"
}
```
Обновляются только переданные (не null) поля.
Поля, не относящиеся к типу товара, игнорируются.

---

- ### Получение списка товаров по типу 
    GET [/product?type={type}]()
  
Допустимые значения `type`: COMPUTER, HARD_DRIVE, LAPTOP, MONITOR

---

- ### Получение товара по id 
    GET [/product/{id}]()
