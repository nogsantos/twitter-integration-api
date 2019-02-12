#!/bin/bash

function print_created_env_values() {
	printf "Environment values: \n\n"
	echo DB_URL=${DB_URL}
	echo DB_TEST=${DB_TEST}
	echo DB_USER=${DB_USER}
	echo DB_PASSWORD=${DB_PASSWORD}
	echo APPLICATION_NAME=${APPLICATION_NAME}
	echo SERVER_PORT=${SERVER_PORT}
	echo JWT_CLIENT_ID=${JWT_CLIENT_ID}
	echo JWT_CLIENT_SECRET=${JWT_CLIENT_SECRET}
}
