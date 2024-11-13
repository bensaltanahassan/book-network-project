# Step 1: Build the Angular app
FROM node:20 AS build-stage

# Set working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install dependencies
RUN npm install

# Copy all project files
COPY . .

# Build the Angular app
RUN npm run build

# Step 2: Set up Nginx to serve the Angular app
FROM nginx:alpine

# Copy custom Nginx configuration file
COPY nginx.conf /etc/nginx/nginx.conf

# Copy built Angular files from build-stage to Nginx html directory
COPY --from=build-stage /app/dist/book-network-ui /usr/share/nginx/html

# Expose port 80
EXPOSE 80

# Start Nginx
CMD ["nginx", "-g", "daemon off;"]
