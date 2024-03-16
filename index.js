import express from 'express';

import { createTable } from './repositories/user-repositories.js';
import { getAllUsers, getUserLogged, registerNewAccount, updateUserAccount, deleteUserAccount } from './controllers/user-controller.js';

const server = express();
const PORT = 5001;

server.use(express.json());
server.use(express.urlencoded({ extended: true }));


createTable();

server.listen(PORT, () => {
    console.log(`> Server running at: http://localhost:${PORT}`);
})


server.get('/users', async (req, res) => await getAllUsers(req, res));
server.get('/users/:id', async (req, res) => await getUserLogged(req, res));
server.post('/users', async (req, res) => await registerNewAccount(req, res));
server.put('/users/:id', async (req, res) => await updateUserAccount(req, res));
server.delete('/users/:id', async (req, res) => await deleteUserAccount(req, res));