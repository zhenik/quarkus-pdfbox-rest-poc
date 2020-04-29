MVN := ./mvnw

.PHONY: all dev compile-native build-image
all: dev

dev:
	${MVN} compile quarkus:dev
# compile inside container for Linux OS
compile-native:
	./mvnw package -Pnative -Dquarkus.native.container-build=true \
      -Dquarkus.native.container-runtime=docker
build-image:
	docker build -f src/docker/Dockerfile.native -t zhenik/pdf-gen-test:1.00 .
