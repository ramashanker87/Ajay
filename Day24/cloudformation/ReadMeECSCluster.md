# Creating ECS Cluster

## Create Using Cloudformation
    aws cloudformation deploy --template-file ecs-cluster.yml --stack-name ajay-ecs-cluster
### List cluster
    aws ecs list-clusters
### List cluster service
    aws ecs list-services --cluster <CLUSTER_NAME> 
    aws ecs list-services --cluster ajay-test-calculator-cluster