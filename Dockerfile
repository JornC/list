FROM maven:3-openjdk-11 as builder

WORKDIR /app

COPY . .
RUN mvn clean install

RUN mkdir /out
RUN unzip /app/yogh-list-server/target/lists.war -d /out

FROM alpine

COPY --from=builder /out /web

