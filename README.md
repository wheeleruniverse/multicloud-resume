# Multicloud Resume Challenge

[![app-aws](https://github.com/wheelers-websites/Resume/actions/workflows/app-aws.yml/badge.svg)](https://github.com/wheelers-websites/Resume/actions/workflows/app-aws.yml)
[![app-azure](https://github.com/wheelers-websites/Resume/actions/workflows/app-azure.yml/badge.svg)](https://github.com/wheelers-websites/Resume/actions/workflows/app-azure.yml)
[![app-core](https://github.com/wheelers-websites/Resume/actions/workflows/app-core.yml/badge.svg)](https://github.com/wheelers-websites/Resume/actions/workflows/app-core.yml)
[![app-gcp](https://github.com/wheelers-websites/Resume/actions/workflows/app-gcp.yml/badge.svg)](https://github.com/wheelers-websites/Resume/actions/workflows/app-gcp.yml)
[![web](https://github.com/wheelers-websites/Resume/actions/workflows/web.yml/badge.svg?branch=main)](https://github.com/wheelers-websites/Resume/actions/workflows/web.yml)

A comprehensive multicloud serverless resume application built in response to the [Meta Resume Challenge](https://dev.to/wheeleruniverse/meta-resume-challenge-5a1a), demonstrating professional cloud development skills across **AWS**, **Azure**, and **Google Cloud Platform**.

## 🌟 Project Overview

This project showcases a complete three-tier serverless application deployed across multiple cloud providers with complete isolation, demonstrating expertise in:

- **Multicloud Architecture**: Single codebase deployed to AWS, Azure, and GCP
- **Serverless Computing**: Cloud Functions, Lambda, and Cloud Run
- **Infrastructure as Code**: Terraform for all cloud resources
- **CI/CD**: GitHub Actions for automated deployments
- **Modern Web Development**: Angular with responsive design
- **Enterprise Java**: Spring Boot with comprehensive testing

## 🏗️ Architecture

### High-Level Architecture
```
Frontend (Angular) ──► API Gateway ──► Serverless Functions ──► Cloud Databases
     │                     │                    │                      │
   Static Web          Load Balancer       Business Logic        Data Storage
  (CDN + Storage)                         (Spring Boot)         (NoSQL DBs)
```

### Cloud Platform Distribution

| Component | AWS | Azure | GCP |
|-----------|-----|-------|-----|
| **Frontend** | CloudFront + S3 | Static Web Apps | Cloud Storage + CDN |
| **API** | API Gateway + Lambda | Function App | Cloud Run |
| **Database** | DynamoDB | Cosmos DB | Firestore |
| **Storage** | S3 Buckets | Blob Storage | Cloud Storage |
| **CDN** | CloudFront | Front Door | Cloud CDN |

## 🛠️ Technology Stack

### Backend
- **Java 11** with **Spring Boot 2.5.4**
- **Maven** for dependency management
- **Spring Cloud Function** for serverless compatibility
- **Lombok** for code generation
- **Swagger/OpenAPI** for API documentation
- **JUnit 5** + **Mockito** for comprehensive testing

### Frontend
- **Angular 11** with TypeScript
- **NgRx** for state management  
- **Angular Material** for UI components
- **Bootstrap** for responsive design
- **FontAwesome** for icons
- **SCSS** for styling

### Infrastructure
- **Terraform** for Infrastructure as Code
- **GitHub Actions** for CI/CD
- **Docker** for containerization
- **AWS CodeArtifact** for artifact management

## 📁 Project Structure

```
multicloud-resume/
├── app/                    # Backend applications
│   ├── core/              # Shared business logic and models
│   ├── aws/               # AWS Lambda implementation
│   ├── azure/             # Azure Functions implementation
│   └── gcp/               # Google Cloud Run implementation
├── web/                   # Angular frontend application
├── iac/                   # Infrastructure as Code
│   ├── terraform/         # Terraform configurations
│   │   ├── aws/          # AWS resources
│   │   ├── azure/        # Azure resources
│   │   └── gcp/          # GCP resources
│   ├── data/             # Resume data (JSON/Excel)
│   ├── diagrams/         # Architecture diagrams
│   └── scripts/          # Deployment scripts
└── README.md
```

## 🚀 Getting Started

### Prerequisites
- **Java 11+**
- **Node.js 14+**
- **Maven 3.6+**
- **Angular CLI**
- **Terraform 1.0+**
- **Docker**
- Cloud CLI tools (AWS CLI, Azure CLI, gcloud)

### Local Development

1. **Clone the repository**
   ```bash
   git clone https://github.com/wheelers-websites/Resume.git
   cd multicloud-resume
   ```

2. **Build the core module**
   ```bash
   cd app/core
   mvn clean install
   ```

3. **Run cloud-specific applications**
   ```bash
   # AWS (requires SAM CLI)
   cd app/aws
   mvn clean package
   sam local start-api
   
   # Azure (requires Azure Functions Core Tools)
   cd app/azure
   mvn clean package
   func start
   
   # GCP (standard Spring Boot)
   cd app/gcp
   mvn spring-boot:run
   ```

4. **Start the frontend**
   ```bash
   cd web
   npm install
   ng serve
   ```

### Deployment

Each cloud platform has dedicated Terraform configurations:

```bash
# AWS
cd iac/terraform/aws
terraform init
terraform plan
terraform apply

# Azure  
cd iac/terraform/azure
terraform init
terraform plan
terraform apply

# GCP
cd iac/terraform/gcp
terraform init
terraform plan
terraform apply
```

## 🔧 Configuration

### Environment-Specific Settings

The application supports multiple deployment environments through configuration files:

- `web/src/environments/environment.aws.ts` - AWS configuration
- `web/src/environments/environment.azure.ts` - Azure configuration  
- `web/src/environments/environment.gcp.ts` - GCP configuration

### Cloud Provider Endpoints

| Provider | Frontend URL | API URL |
|----------|-------------|---------|
| **AWS** | `wheelercloudguru.com` | `api.aws.wheelercloudguru.com` |
| **Azure** | `wheelercloudguru.azurewebsites.net` | `wheelercloudguru.azurewebsites.net/api` |
| **GCP** | `gcp.wheelercloudguru.com` | `api.gcp.wheelercloudguru.com` |

## 📊 Features

### Core Resume Sections
- **About**: Personal introduction and photos
- **Experience**: Professional work history with detailed descriptions
- **Education**: Academic background and achievements
- **Skills**: Technical and professional competencies with proficiency levels
- **Certifications**: Industry certifications with vendor information
- **Projects**: Portfolio of significant projects with architecture diagrams
- **Visitor Counter**: Real-time visitor tracking across all platforms

### Technical Features
- **Responsive Design**: Optimized for desktop, tablet, and mobile
- **Real-time Data**: Dynamic content loading from cloud databases
- **Cross-Platform**: Consistent experience across all cloud providers
- **SEO Optimized**: Proper meta tags and structured data
- **Performance**: CDN distribution and caching strategies
- **Security**: HTTPS enforcement and secure API endpoints

## 🧪 Testing

### Backend Testing
```bash
cd app/core
mvn test                    # Unit tests
mvn integration-test        # Integration tests
```

### Frontend Testing
```bash
cd web
npm test                    # Unit tests
npm run e2e                 # End-to-end tests
npm run lint                # Code linting
```

## 📈 CI/CD Pipeline

The project uses **GitHub Actions** for automated deployments with separate workflows:

- **app-core.yml**: Builds and tests the shared core module
- **app-aws.yml**: Deploys AWS Lambda functions
- **app-azure.yml**: Deploys Azure Functions
- **app-gcp.yml**: Deploys GCP Cloud Run services
- **web.yml**: Builds and deploys the frontend to all platforms

### Deployment Strategy
1. **Code Push**: Triggers automated builds
2. **Testing**: Runs comprehensive test suites
3. **Build**: Creates deployment artifacts
4. **Deploy**: Pushes to respective cloud platforms
5. **Validate**: Performs health checks

## 🏆 Challenge Compliance

This project fulfills all requirements of the Meta Resume Challenge:

### ✅ Core Requirements
- [x] **Three-tier architecture**: Frontend, Backend, Database
- [x] **Multiple cloud providers**: AWS, Azure, GCP with complete isolation
- [x] **Serverless architecture**: Functions, Lambda, Cloud Run
- [x] **Infrastructure as Code**: Complete Terraform configurations
- [x] **CI/CD Pipeline**: GitHub Actions for all components
- [x] **Version Control**: Git with proper branching strategy
- [x] **Domain Registration**: Custom domains for each platform

### ✅ Technical Implementation
- [x] **Database Storage**: Resume data stored in cloud databases (not hardcoded)
- [x] **API Development**: RESTful APIs with proper documentation
- [x] **Frontend Framework**: Modern Angular application
- [x] **Responsive Design**: Mobile-first approach
- [x] **Security**: HTTPS, CORS, secure endpoints
- [x] **Monitoring**: Application insights and logging

### ✅ Advanced Features
- [x] **Visitor Counter**: Real-time tracking across platforms
- [x] **Performance Optimization**: CDN, caching, compression
- [x] **Code Quality**: Comprehensive testing, linting, code coverage
- [x] **Documentation**: Detailed README, API documentation
- [x] **Architectural Diagrams**: Visual system representation

## 🎯 Live Demos

Experience the multicloud resume across different platforms:

- **AWS**: [wheelercloudguru.com](https://wheelercloudguru.com)
- **Azure**: [wheelercloudguru.azurewebsites.net](https://wheelercloudguru.azurewebsites.net)
- **GCP**: [gcp.wheelercloudguru.com](https://gcp.wheelercloudguru.com)

## 📚 Additional Resources

### Original Challenge References
- [AWS Cloud Resume Challenge](https://forrestbrazeal.com/2020/04/23/the-cloud-resume-challenge/)
- [Azure Cloud Resume Challenge](https://acloudguru.com/blog/engineering/cloudguruchallenge-your-resume-in-azure)
- [GCP Cloud Resume Challenge](https://acloudguru.com/blog/engineering/cloudguruchallenge-your-resume-on-gcp)
- [Meta Resume Challenge Blog Post](https://dev.to/wheeleruniverse/meta-resume-challenge-5a1a)

### Architecture Diagrams
- [Meta Resume Challenge Architecture](iac/diagrams/MetaResumeChallenge_20210814.png)
- [Serverless Resume Architecture](iac/diagrams/ServerlessResume_20210528.png)

## 📄 License

This project is open source and available under the [MIT License](LICENSE).

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request. For major changes, please open an issue first to discuss what you would like to change.

## 📧 Contact

For questions or collaboration opportunities, please reach out through the contact information available on the live resume sites.

---

*This project demonstrates enterprise-level cloud development skills and serves as a comprehensive example of multicloud architecture implementation.*