# Service Discovery

## Dependências:

- Eureka Server 

## Anotações:

- @EnableEurekaServer

<br>

# Gateway

## Dependências:

- Eureka Discovery Client
- Gateway

## Anotações:

- @EnableEurekaClient

<br>

# People Control

## Dependências:

- Spring Web
- Eureka Discovery Client
- Lombok
- PostgreSQL Driver
- Spring Data JPA
- ModelMapper

## Anotações:

- @Getter
- @Settert
- @RestController
- @RequestMapping
- @EnableEurekaServer

<br>

# Animal Control

## Dependências:

- Spring Web
- Eureka Discovery Client
- Lombok
- PostgreSQL Driver
- Spring Data JPA
- Validation
- ModelMapper

## Anotações:

- @Getter
- @Settert
- @RestController
- @RequestMapping
- @EnableEurekaServer
- @Id
- @Entity
- GeneratedValue(strategy = GenerationType.AUTO)
- @AllArgsConstructor
- @NoArgsConstructor
- @Autowired
- @Value
- @PostMapping
- @RequestBody
- @PathVariable
- @GetMapping
- @DeleteMapping
- @PutMapping
- @Service
- @ResponseStatus(code = HttpStatus.NOT_FOUND)
- @ControllerAdvice
- @ExceptionHandler(ResourceNotFoundException.class)
- @PatchMapping