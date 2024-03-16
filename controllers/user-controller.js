import express from 'express';

import { createTable, createUser, getUsers, getUserById, updateUser, deleteUser } from '../repositories/user-repositories.js';
import { User } from '../models/user.js';

export async function getAllUsers(req, res) {
    try {
        const users = await getUsers();
        res.send(users);
    }
    catch (error) {
        res.statusCode(404);
    }
}

export async function getUserLogged(req, res) {
    try {
        const { id } = req.params;
        const user = await getUserById(id);
        res.send(user);
    }
    catch (error) {
        res.send(error);
    }
}

export async function registerNewAccount(req, res) {
    try {
        const { name, email, password } = req.body;

        const user = new User();

        user.name = name;
        user.email = email;
        user.password = password;
        user.balance = 0.00;

        createUser(user);

        res.send(user)
    } catch (error) {
        res.send(error);
    }
}

export async function updateUserAccount(req, res) {
    try {
        const { name, email, balance } = req.body;
        const user = new User();

        user.id = req.params.id;
        user.name = name;
        user.email = email;
        user.balance = balance;

        const result = await updateUser(user);

        res.send({message: 'User updated!', statusCode: 204});

    } catch (error) {
        res.send(error);
    }
}

export async function deleteUserAccount(req, res) {
    try {
        const { id } = req.params;
        const result = await deleteUser(id);
        res.send(result);
    } catch (error) {
        res.send(error);
    }
}