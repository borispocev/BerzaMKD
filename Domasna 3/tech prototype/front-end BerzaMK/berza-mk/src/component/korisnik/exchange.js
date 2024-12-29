import React, { useState } from "react";
import '../../exchange.css';

const Exchange = () => {
  const [isBuy, setIsBuy] = useState(true);
  const [fromValue, setFromValue] = useState(4.763);
  const [toValue, setToValue] = useState(76.4);

  return (
    <div className="bg-white shadow-lg rounded-lg p-6 w-96 mx-auto">
      <h2 className="text-gray-900 text-lg font-bold mb-4">Exchange</h2>

      {/* Buy/Sell Toggle */}
      <div className="flex justify-center mb-6">
        <button
          className={`px-6 py-2 font-medium rounded-l-full ${
            isBuy ? "bg-blue-500 text-white" : "bg-gray-200 text-gray-700"
          }`}
          onClick={() => setIsBuy(true)}
        >
          Buy
        </button>
        <button
          className={`px-6 py-2 font-medium rounded-r-full ${
            !isBuy ? "bg-blue-500 text-white" : "bg-gray-200 text-gray-700"
          }`}
          onClick={() => setIsBuy(false)}
        >
          Sell
        </button>
      </div>

      {/* From Section */}
      <div className="mb-4">
        <label className="block text-sm text-gray-500 mb-1">From</label>
        <div className="flex items-center bg-gray-100 rounded-lg shadow-sm p-2">
          <div className="flex items-center gap-2">
            <span className="text-blue-600 text-lg">Ⓜ️</span>
            <select className="bg-transparent outline-none font-medium">
              <option>MAK</option>
              <option>USD</option>
              <option>GBP</option>
            </select>
          </div>
          <input
            type="number"
            className="flex-grow text-right bg-transparent outline-none font-medium"
            value={fromValue}
            onChange={(e) => setFromValue(e.target.value)}
          />
        </div>
      </div>

      {/* Exchange Arrow */}
      <div className="flex justify-center mb-4">
        <button className="text-blue-500">
          🔄
        </button>
      </div>

      {/* To Section */}
      <div className="mb-4">
        <label className="block text-sm text-gray-500 mb-1">To</label>
        <div className="flex items-center bg-gray-100 rounded-lg shadow-sm p-2">
          <div className="flex items-center gap-2">
            <span className="text-yellow-500 text-lg">€</span>
            <select className="bg-transparent outline-none font-medium">
              <option>EUR</option>
              <option>USD</option>
              <option>GBP</option>
            </select>
          </div>
          <input
            type="number"
            className="flex-grow text-right bg-transparent outline-none font-medium"
            value={toValue}
            onChange={(e) => setToValue(e.target.value)}
          />
        </div>
      </div>

      {/* Exchange Rate */}
      <p className="text-gray-500 text-sm mb-6 text-center">
        1 MAK = 5.817 MKD
      </p>

      {/* Exchange Button */}
      <button className="w-full bg-blue-500 text-white py-3 rounded-lg text-center font-medium">
        Exchange
      </button>
    </div>
  );
};

export default Exchange;
