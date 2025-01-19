import React, { useEffect, useState } from 'react'
import axios from 'axios';


  function DataTable2(){
    const [data, setData] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            const responce = await axios.get("http://localhost:8080/api3/allComapny");
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
                    <th>Close</th>
                    <th>High</th>
                    <th>Low</th>
                    <th>Volume</th>
                    <th>Sma 20</th>
                    <th>Sma 50</th>
                    <th>Ema 20</th>
                    <th>Ema 50</th>
                    <th>BB mid</th>
                    <th>Obv</th>
                    <th>Momentum</th>
                    <th>Buy Signal</th>
                    <th>Sell Signal</th>
                    <th colSpan={3}>Action</th>
                </tr>
            </thead>
            <tbody className='text-center'>
                {data.map((item)=>(
                    <tr key={item.id}>
                        <td>{item.id}</td>
                        <td>{item.company_name}</td>
                        <td>{item.close}</td>
                        <td>{item.high}</td>
                        <td>{item.low}</td>
                        <td>{item.volume}</td>
                        <td>{item.sma20}</td>
                        <td>{item.sma50}</td>
                        <td>{item.ema20}</td>
                        <td>{item.ema50}</td>
                        <td>{item.bbmid}</td>
                        <td>{item.obv}</td>
                        <td>{item.momentum}</td>
                        <td>{item.buy_signal}</td>
                        <td>{item.sell_signal}</td>
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

export default DataTable2
