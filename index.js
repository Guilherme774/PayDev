const express = require('express');
const server = express();

const PORT = process.env.PORT;

server.use(express.json());
server.use(express.urlencoded({ extended: true }));

server.listen(PORT, () => {
    console.log(`> Server running at: http://localhost:${PORT}`);
})