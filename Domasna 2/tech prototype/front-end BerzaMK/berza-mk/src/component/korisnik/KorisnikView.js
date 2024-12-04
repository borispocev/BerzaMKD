import React, { useEffect, useState } from 'react'
import axios from 'axios';

const KorisnikView = () => {
    const[korisnici, setKorisnik] = useState([]);

    useEffect(()=> {
        loadClients();
    }, []);

    const loadClients = async()=>{
        const result = await axios.get(
            "http://localhost:8080/api/all",
            {
                validateStatus: () => {
                    return true;
                },
            }
        );
        if(result.status === 302){
            setKorisnik(result.data);
        }
    };

  return (
    <section>
        <table className='table table-bordered table-hover'>
            <thead>
                <tr className='text-center'>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Email</th>
                    <th>Age</th>
                </tr>
            </thead>
            <tbody className='text-center'>
                {korisnici.map((korisnik, index)=>(
                    <tr key={korisnik.id}>
                        <td>{korisnik.id}</td>
                        <td>{korisnik.username}</td>
                        <td>{korisnik.email}</td>
                        <td>{korisnik.age}</td>
                        <td className='mx-2'>
                            <button className='btn btn-info'>View</button>
                        </td>
                        <td className='mx-2'>
                            <button className='btn btn-warning'>Update</button>
                        </td>
                        <td className='mx-2'>
                            <button className='btn btn-danger'>Delete</button>
                        </td>
                    </tr>
                ))}
            </tbody>
        </table>
    </section>
  )
}

export default KorisnikView
