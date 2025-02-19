### How to run document generator on local env
(official doc: https://github.com/awslabs/aws-sam-local)

Installation:
1) Install Docker (https://store.docker.com/editions/community/docker-ce-desktop-mac)
2) Install aws-sam-local: npm install -g aws-sam-local
2.1) Verify the installation worked: sam --version

Usage (run this command from root folder):
1) Invoke function: sam local invoke <function logical id>
OR
2) Run API Gateway locally: sam local start-api

Debugging Applications:
1) Invoke a function locally in debug mode on port 5858: sam local invoke -d 5858 <function logical id>
OR
2) Start local API Gateway in debug mode on port 5858: sam local start-api -d 5858
3) Hit endpoint: http://127.0.0.1:3000/<function logical id>
4) Run debugger
