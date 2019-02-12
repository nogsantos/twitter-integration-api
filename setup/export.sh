#!/bin/bash

function export_env_to_session() {
	printf "Setting up environment system... \n\n"
	export $(cat .env)
}
