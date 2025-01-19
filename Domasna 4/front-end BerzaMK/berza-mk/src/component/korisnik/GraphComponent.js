import React, { useState, useEffect } from "react";
import axios from "axios";
import { Line } from "react-chartjs-2";
import { Chart as ChartJS, CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend } from "chart.js";
import '../../graphcs.css';

ChartJS.register(CategoryScale, LinearScale, PointElement, LineElement, Title, Tooltip, Legend);

const GraphComponent = () => {
  const [companies, setCompanies] = useState([]);
  const [selectedCompany, setSelectedCompany] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [chartData, setChartData] = useState(null);

  // Fetch companies from backend
  useEffect(() => {
    axios.get("http://localhost:8080/api2/companyName")
      .then(response => {
        console.log("Fetched companies:", response.data);  // Log the response to verify
        setCompanies(response.data); // Update the state with the array of company names
      })
      .catch(error => {
        console.error("Error fetching companies:", error);
      });
  }, []);

  // Fetch data based on company and date range
  useEffect(() => {
    if (selectedCompany && startDate && endDate) {
      axios.get(`http://localhost:8080/api3/getData?companyName=${selectedCompany}&startDate=${startDate}&endDate=${endDate}`)
        .then(response => {
          const data = response.data;
          const dates = data.map(item => item.date);
          const closeValues = data.map(item => parseFloat(item.close));
          const ema20Values = data.map(item => parseFloat(item.ema20));
          const ema50Values = data.map(item => parseFloat(item.ema50));
          const rsiValues = data.map(item => parseFloat(item.rsi));
          const sma20Values = data.map(item => parseFloat(item.sma20));
          const sma50Values = data.map(item => parseFloat(item.sma50));

          // Prepare chart data with multiple datasets
          setChartData({
            labels: dates,
            datasets: [
              {
                label: "Close Price",
                data: closeValues,
                borderColor: "rgba(75, 192, 192, 1)",
                tension: 0.1,
                fill: false,
              },
              {
                label: "EMA20",
                data: ema20Values,
                borderColor: "green",
                backgroundColor: "rgba(0, 255, 0, 0.2)",
                fill: false,
              },
              {
                label: "EMA50",
                data: ema50Values,
                borderColor: "orange",
                backgroundColor: "rgba(255, 165, 0, 0.2)",
                fill: false,
              },
              {
                label: "RSI",
                data: rsiValues,
                borderColor: "purple",
                backgroundColor: "rgba(128, 0, 128, 0.2)",
                fill: false,
              },
              {
                label: "SMA20",
                data: sma20Values,
                borderColor: "red",
                backgroundColor: "rgba(255, 0, 0, 0.2)",
                fill: false,
              },
              {
                label: "SMA50",
                data: sma50Values,
                borderColor: "yellow",
                backgroundColor: "rgba(255, 255, 0, 0.2)",
                fill: false,
              },
            ],
          });
        })
        .catch(error => console.error("Error fetching data:", error));
    }
  }, [selectedCompany, startDate, endDate]);

  const handleCompanyChange = (event) => {
    setSelectedCompany(event.target.value);
  };

  const handleStartDateChange = (event) => {
    setStartDate(event.target.value);
  };

  const handleEndDateChange = (event) => {
    setEndDate(event.target.value);
  };

  return (
    <div className="graph-container">
      <h2>Interactive Stock Data Graph</h2>
      <div className="select-container">
        <label htmlFor="company">Select Company:</label>
        <select id="company" value={selectedCompany} onChange={handleCompanyChange}>
          <option value="">--Select Company--</option>
          {companies.length > 0 ? (
            companies.map((company, index) => (
              <option key={index} value={company}>
                {company}
              </option>
            ))
          ) : (
            <option value="">Loading...</option>
          )}
        </select>
      </div>
  
      <div className="select-container">
        <label htmlFor="startDate">Select Start Date:</label>
        <input type="date" id="startDate" value={startDate} onChange={handleStartDateChange} />
      </div>
  
      <div className="select-container">
        <label htmlFor="endDate">Select End Date:</label>
        <input type="date" id="endDate" value={endDate} onChange={handleEndDateChange} />
      </div>
  
      <div className="chart-container"  style={{ position: "relative", height: "450px" }}>
        {chartData ? (
          <Line data={chartData} options={{ responsive: true, maintainAspectRatio: false }} />
        ) : (
          <p>Please select company and date range to view the graph.</p>
        )}
      </div>
    </div>
  );  
};

export default GraphComponent;
