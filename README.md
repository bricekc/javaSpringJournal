# 1. Crée un utilisateur IAM
aws iam create-user --user-name terraform-ci

# 2. Crée une access key pour cet utilisateur
aws iam create-access-key --user-name terraform-ci

# 3. Attache la policy AdministratorAccess (full rights)
aws iam attach-user-policy --user-name terraform-ci --policy-arn arn:aws:iam::aws:policy/AdministratorAccess

