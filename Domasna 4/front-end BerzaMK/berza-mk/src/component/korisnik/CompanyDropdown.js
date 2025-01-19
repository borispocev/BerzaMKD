import React, { useEffect, useState } from "react";

function CompanyDropdown() {
  const [companies, setCompanies] = useState([]);
  const [selectedCompany, setSelectedCompany] = useState("");

  // Fetch company names from the backend
  useEffect(() => {
    fetch("http://localhost:8080/api2/companyName") // Adjust this to match your actual API endpoint
      .then((response) => {
        if (!response.ok) {
          throw new Error("Network response was not ok");
        }
        return response.json();
      })
      .then((data) => {
        setCompanies(data); // Assuming the backend returns an array of strings
      })
      .catch((error) => {
        console.error("Error fetching company names:", error);
      });
  }, []);

  // Handle dropdown selection
  const handleChange = (event) => {
    setSelectedCompany(event.target.value);
  };

  return (
    <div>
      <label htmlFor="company-select">Select a Company:</label>
      <select
        id="company-select"
        value={selectedCompany}
        onChange={handleChange}
      >
        <option value="" disabled>
          -- Choose a Company --
        </option>
        {companies.map((company, index) => (
          <option key={index} value={company}>
            {company}
          </option>
        ))}
      </select>
    </div>
  );
}

export default CompanyDropdown;
