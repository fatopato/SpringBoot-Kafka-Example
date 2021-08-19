# SpringBoot Kafka Örnek Uygulama

Kitap satışlarının takibini gerçekleştiren Kafka ile oluşturulmuş Spring Boot uygulaması

# Apache Kafka kurulumu

Apache Kafka'yı indirip dosyaları çıkartın

Çıkartılan kafka klasörüne gidin

(Buradaki şekilde kurulum yapılabilir: https://kafka.apache.org/quickstart)

# Zookeper'i ayaklandırma

Kafka klasörü içerisinde terminal penceresinde şu komut çalıştırılarak zookeeper default ayarlar ile çalıştırılır:

```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```
# Kafka broker (server) ayaklandırma

Kafka klasörü içerisinde yeni bir terminal penceresinde şu komut ile broker başlatılır:

```shell
bin/kafka-server-start.sh config/server.properties
```

# Mesajlara erişmek için consumer ayaklandırma

Yeni bir terminalde aşağıdaki komut ile consumer ayaklandırılabilir:

```shell
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic BookTransaction --from-beginning
```

# Spring Boot uygulamasını ayaklandırmak

Spring Boot uygulamasını ayaklandırdığınızda server **8080** portunu kullanacaktır.

Start the spring boot app and the server will start on the port **8080**. 

Post isteği ile kafka test edilebilir. Yeni bir terminalden atılan curl komutu ile istek atılabilir.

Örnek curl isteği:

```shell
curl --location --request POST 'http://localhost:8080/book/transaction' \
--header 'Content-Type: application/json' \
--data-raw '{
    "isbn": "123-5266-56",
    "transactionType": "RETURN",
    "amount": 1
}'
```

İstek sonrasında Spring Boot uygulamasının konsolunda ve consumer terminalinde mesajları görebilirsiniz.
