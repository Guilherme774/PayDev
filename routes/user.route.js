import express from 'express';
import { getAllUsers, getUserLogged, registerNewAccount, updateUserAccount, deleteUserAccount } from '../controllers/user-controller.js';

const router = express.Router();

router.route('/').get(getAllUsers);
router.route('/:id').get(getUserLogged);
router.route('/').post(registerNewAccount);
router.route('/:id').put(updateUserAccount);
router.route('/:id').delete(deleteUserAccount);

export default router;