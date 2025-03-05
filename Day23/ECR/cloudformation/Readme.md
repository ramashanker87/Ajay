# Create CloudFormation for ECR

## Execute cloudformation to create ecr repository

    aws cloudformation deploy --template-file ecr-template.yml --stack-name create-ecr-repo-prashant 

## Verify ECR

###  List all ECR repositories:

    aws ecr describe-repositories 

### Check details of a specific repository:

    aws ecr describe-repositories --repository-names prashant-microservice-repo 

### List images in the repository:

    aws ecr list-images --repository-name prashant-microservice-repo

### Login to ECR (for Docker):

    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com

## Push Image to ECR

### Build docker image
docker build -t prashant-microservice-repo .



### Tag Image with ECR Repository URL:

docker tag prashant-microservice-repo:latest 975050323630.dkr.ecr.us-east-1.amazonaws.com/prashant-microservice-repo:latest

    
### Login to ECR (for Docker):

    aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 975050323630.dkr.ecr.us-east-1.amazonaws.com

### Push images:

docker push 975050323630.dkr.ecr.us-east-1.amazonaws.com/prashant-microservice-repo:latest
    

### List images in the repository:
    aws ecr list-images --repository-name prashant-microservice-repo
