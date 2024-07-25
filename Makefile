
start:
	docker-compose up -d

build:
	@./gradlew build --warning-mode all

run-tests:
	@./gradlew test --warning-mode all

test:
	@docker exec recursos-test_server ./gradlew test --warning-mode all

run:
	@./gradlew :run

ping-mysql:
	@docker exec shared_mysql mysqladmin --user=root --password= --host "127.0.0.1" ping --silent

# Start the app
start-back:
	@./gradlew bootRun --args='platform_backend server'

clean:
	@./gradlew clean

down:
	docker stop $(docker ps -q)
