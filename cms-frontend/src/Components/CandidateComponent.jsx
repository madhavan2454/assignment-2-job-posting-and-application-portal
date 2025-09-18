 import React, { useEffect, useState } from 'react'
import { createCandidate, getCandidateById, updateCandidate } from '../services/CandidateService'
import { useNavigate, useParams} from 'react-router-dom'

function CandidateComponent() {

  const [name, setName] = useState('')
  const [email, setEmail] = useState('')
  const [phoneNumber, setPhone] = useState('')
  const [resumeLink, setResume] = useState('')
  const [currentStatus, setStatus] = useState('')

  const {id} =useParams();

  const [errors, setErrors] = useState({
    name: '',
    email: '',
    phoneNumber: '',
    resumeLink: '',
    currentStatus: ''
  })

  const navigate = useNavigate();

  useEffect(() => {

    if(id){
      getCandidateById(id).then(response => {
        setName(response.data.name)
        setEmail(response.data.email)
        setPhone(response.data.phoneNumber)
        setResume(response.data.resumeLink)
        setStatus(response.data.currentStatus)
      }).catch(error => {
        console.error(error);
      })
    }
  }, [id])

  function saveOrUpdateCandidate(event){
    event.preventDefault();
    if(validateForm()){
      const candidate = {name, email, phoneNumber, resumeLink, currentStatus}
      console.log(candidate)

      if(id){
        updateCandidate(id, candidate).then(response => {
          console.log(response.data)
          navigate('/CandidateList')
        }).catch(error => {
          console.error(error);
        })
      }
      else{
        createCandidate(candidate).then((response) => {
          console.log(response.data)
          navigate('/CandidateList')
        }).catch(error => {
          console.error(error);
        })
      }
    }
      
  }

  function validateForm() {
    let valid = true;

    const copyErrors = {... errors}

    if(name.trim()){
      copyErrors.name = '';
    }
    else{
      copyErrors.name = 'Name is required';
      valid = false;
    }
    if(email.trim()){
      copyErrors.email = '';
    }
    else{
      copyErrors.email = 'Email is required';
      valid = false;
    }
    if(phoneNumber.trim()){
      copyErrors.phoneNumber = '';
    }
    else{
      copyErrors.phoneNumber = 'Phone Number is required';
      valid = false;
    }
    if(resumeLink.trim()){
      copyErrors.resumeLink = '';    
    }
    else{
      copyErrors.resumeLink = 'Resume Link is required';
      valid = false;
    }
    if(currentStatus.trim()){
      copyErrors.currentStatus = '';
    }
    else{
      copyErrors.currentStatus = 'Status is required';
      valid = false;
    }
    setErrors(copyErrors);
    return valid;
   }

   function pageTitle(){
    if(id){
      return <h2 className='text-center'>Update Candidate</h2>
    }
    else{
      return <h2 className='text-center'>Add Candidate</h2>
    }
   }

  return (
    <div className='container'>
      <br /> <br />
      <div className='row'>
        <div className='card col-md-6 offset-md-3 offset-md-3 shadow p-3 mb-5 bg-body rounded'>
          {
            pageTitle()
          }
          <div className='card-body'>
            <form>
              <div className='form-group mb-2'>
                <label className='form-label'> Name </label>
                <input
                  type='text'
                  placeholder='Enter Full Name'
                  name='Name'
                  value={name}
                  className={` form-control ${errors.name ? 'is-invalid' : ''}`}
                  onChange={(event) =>setName(event.target.value)}
                  >
                </input>
                {errors.name && <div className='invalid-feedback'> {errors.name} </div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'> Email </label>
                <input
                  type='text'
                  placeholder='Enter Email'
                  name='Email'
                  value={email}
                  className={` form-control ${errors.email ? 'is-invalid' : ''}`}
                  onChange={(event) => setEmail(event.target.value)}
                  >
                </input>
                {errors.email && <div className='invalid-feedback'> {errors.email} </div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'> Phone</label>
                <input
                  type='number'
                  placeholder='Enter Phone Number'
                  name='Phone'
                  value={phoneNumber}
                  className={` form-control ${errors.phoneNumber ? 'is-invalid' : ''}`}
                  onChange={(event) => setPhone(event.target.value)}
                  >
                </input>
                {errors.phoneNumber && <div className='invalid-feedback'> {errors.phoneNumber} </div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'> Resume</label>
                <input
                  type='text'
                  placeholder='Add your Resume Link'
                  name='Resume'
                  value={resumeLink}
                  className={` form-control ${errors.resumeLink ? 'is-invalid' : ''}`}
                  onChange={(event) =>setResume(event.target.value)}
                  >
                </input>
                {errors.resumeLink && <div className='invalid-feedback'> {errors.resumeLink} </div>}
              </div>

              <div className='form-group mb-2'>
                <label className='form-label'> Status</label>
                <input
                  type='text'
                  placeholder='Status'
                  name='Status'
                  value={currentStatus}
                  className={` form-control ${errors.currentStatus ? 'is-invalid' : ''}`}
                  onChange={(event) => setStatus(event.target.value)}
                  >
                </input>
                {errors.currentStatus && <div className='invalid-feedback'> {errors.currentStatus} </div>}
              </div>

              <button className='btn btn-success' onClick={saveOrUpdateCandidate}> Submit</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  )
}

export default CandidateComponent 



