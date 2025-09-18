import React, {useEffect, useState} from 'react'
import { deleteCandidate, getCandidates } from '../services/CandidateService';
import { useNavigate } from 'react-router-dom';
function CandidateList() {

    const [candidates, setCandidates] = useState([])

    const navigate = useNavigate();

    useEffect(() => {
        getAllCandidates();
    }, [])

    function getAllCandidates(){
        getCandidates().then((response) => {
            setCandidates(response.data);
        }).catch(error => {
            console.error(error);
        })
    }

    function addNewCandidate() {
        navigate('/add-candidate')
    }

    function updateCandidate(id) {
        navigate(`/edit-candidate/${id}`)
    }

    function removeCandidate(id) {
        console.log(id)
        deleteCandidate(id).then((response) => {
            getAllCandidates();
        }).catch(error => {
            console.error(error);
        })
    }
  return (
    <div className='container'>
        <h2 className='text-center'> List of Candidates</h2>
        <button className=' addcandidate' onClick={addNewCandidate}> Add Candidate</button>
        <table className=" table table bordered table-striped candidate-table ">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>PhoneNo</th>
                    <th>ResumeLink</th>
                    <th>CurrentStatus</th>
                    <th>Actions</th>
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
                            <td>
                                <button className='btn btn-info' onClick={() => updateCandidate(candidate.id)}>Update</button>
                                <button className='btn btn-danger' onClick={() => removeCandidate(candidate.id)} 
                                         style={{marginLeft: "10px"}}> Delete</button>
                            </td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    </div>
  )
}

export default CandidateList
