# Use a lightweight Node.js image
FROM node:18-alpine

# Set the working directory
WORKDIR /app

# Copy package.json and install dependencies
COPY package.json .
RUN npm install

# Copy the server code
COPY server.js .

# Expose the standard 8080 port
EXPOSE 8080

# Start the server
CMD ["npm", "start"]