import express from 'express';
import cors from 'cors';

import { createTable } from './repositories/user-repositories.js';
import userRouter from './routes/user.route.js';
import transactionRouter from './routes/transaction.route.js';

const server = express();
const PORT = 5001;

server.use(cors());
server.use(express.json());
server.use(express.urlencoded({ extended: true }));


createTable();


server.listen(PORT, () => {
    console.log(`> Server running at: http://localhost:${PORT}`);
})

server.use('/api/v1/users', userRouter);
server.use('/api/v1/transactions', transactionRouter);