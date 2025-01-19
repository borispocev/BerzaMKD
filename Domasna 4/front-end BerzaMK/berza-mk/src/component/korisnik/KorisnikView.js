import React, { useEffect, useState } from 'react'
import axios from 'axios';


  function DataTable(){
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const responce = await axios.get("http://localhost:8080/api2/allComapny");
            setData(responce.data);
    };
    
    fetchData();
  }, []);

  return (
    <section>
        <table className='table table-bordered table-hover'>
            <thead>
                <tr className='text-center'>
                    <th>ID</th>
                    <th>Company Name</th>
                    <th>Data</th>
                    <th>Price</th>
                    <th>Total Turnover Percent</th>
                    <th>Quantity</th>
                    <th>BestMKD</th>
                    <th>Total Turnover</th>
                    <th colSpan={3}>Action</th>
                </tr>
            </thead>
            <tbody className='text-center'>
                {data.map((item)=>(
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.companyName}</td>
                        <td>{item.data}</td>
                        <td>{item.price}</td>
                        <td>{item.procentOfTotalTurnover}</td>
                        <td>{item.quantity}</td>
                        <td>{item.bestmkd}</td>
                        <td>{item.totalTurnover}</td>
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

export default DataTable
