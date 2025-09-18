import axios from 'axios';

const REST_API_BASE_URL = "http://localhost:8080/api/candidates";

export const getCandidates = () => axios.get(REST_API_BASE_URL);

export const createCandidate = (candidate) => axios.post(REST_API_BASE_URL, candidate);

export const getCandidateById = (id) => axios.get(REST_API_BASE_URL + '/' + id);

export const updateCandidate = (id, candidate) => axios.put(REST_API_BASE_URL + '/' + id, candidate);

export const deleteCandidate = (id) => axios.delete(REST_API_BASE_URL + '/' + id);