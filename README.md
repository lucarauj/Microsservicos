# Service Discovery

## Dependências:

- Eureka Server
- Spring Cloud Config
- Spring Cloud Bootstrap
 

## Anotações:

- @EnableEurekaServer

# Gateway Zuul

## Dependências:

- Eureka Discovery Client
- Spring Cloud Starter Netflix Zuul
- Spring Cloud Config
- Spring Cloud Bootstrap

## Anotações:

- @EnableEurekaClient
- @EnableZuulProxy

# People Control

## Dependências:

- Spring Web
- Eureka Discovery Client
- Lombok
- PostgreSQL Driver
- Spring Data JPA
- ModelMapper
- Spring Cloud Config
- Spring Cloud Bootstrap

## Anotações:

- @Getter
- @Settert
- @RestController
- @RequestMapping
- @EnableEurekaServer

# Animal Control

## Dependências:

- Spring Web
- Eureka Discovery Client
- Lombok
- PostgreSQL Driver
- Spring Data JPA
- Validation
- ModelMapper
- Spring Cloud Config
- Spring Cloud Bootstrap

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