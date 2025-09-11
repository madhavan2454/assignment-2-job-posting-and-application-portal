import React, {useEffect, useState} from 'react'
import { getCandidates } from '../services/CandidateService';

function CandidateList() {

    const [candidates, setCandidates] = useState([])
    useEffect(() => {
        getCandidates().then((response) => {
            setCandidates(response.data);
        }).catch(error => {
            console.error(error);
        })
    }, [])
  return (
    <div className='container'>
        <h2 className='text-center'> List of Candidates</h2>
        <table className=" table table bordered table-striped candidate-table ">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>PhoneNo</th>
                    <th>ResumeLink</th>
                    <th>CurrentStatus</th>
                </tr>
            </thead>

            <tbody>
                {
                    candidates.map((candidate) => (
                        <tr key= {candidate.id}>
                            <td> {candidate.id}</td>
                            <td> {candidate.name}</td>
                            <td> {candidate.email}</td>
                            <td> {candidate.phoneNumber}</td>
                            <td> {candidate.resumeLink}</td>
                            <td> {candidate.currentStatus}</td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
  )
}

export default CandidateList
