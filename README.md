# Spring AI

![yes](https://img.shields.io/badge/Maintained%3F-yes-green.svg)
![commit](https://img.shields.io/github/commits-since/yhdchoi/fiorano/1.0.svg)

![java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
![postgresql](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white)
![notion](https://img.shields.io/badge/Notion-%23000000.svg?style=for-the-badge&logo=notion&logoColor=white)
![figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=figma&logoColor=white)
![intellij](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)

## Getting started

> The project is packaged into docker images.
> In this case you must install Docker on your environment to start the application.
> To run the project, please run the command below.

```shell
sudo sh start.sh
```

> ❗️Note: Must create your own api keys for the Ai models.
> Currently, OpenApi and Anthropic(Claude) api keys must be defined in the environment file.

## Ai Chatbot

![chatbot](./readme/image/chat-generator-diagram.png)

> I have created a simple Ai chatbot using multiple models.
> In future release I will be adding more models to the service.

## Image Generator

> Along with the chatbot, I have implemented an image generator.

## Advisor

![advisor](./readme/image/advisor-diagram.png)

> I have put together a Financial Advisor as an example. 
> But it can be converted to other types of advisor depends on the document you ingest to the vector database. 

### RAG - Retrieval Augmented Generation

> It combines 'Retrieval-based Methods' with 'Generative Models' to produce more accurate and contextually relevant
> outputs.
> In other words, it allows LLMs to access external knowledge sources, mitigating limitations like outdated information
> or knowledge cutoff

### Not RAG

![not_rag](./readme/image/not-rag-diagram.png)

> When without the RAG, the user fetches all of his/her documents along with the query.
> Sending al of the documents which some part of them are not relevant to the user query is not efficient and accurate.
