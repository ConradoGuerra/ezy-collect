"use client";

import { useState, FormEvent } from "react";
import styles from "../../app/page.module.css";

interface WebhookData {
  url: string;
}

const WebhookForm = () => {
  const [webhookData, setWebhookData] = useState<WebhookData>({
    url: "",
  });

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    const webhookDataToSend: WebhookData = { ...webhookData };

    try {
      const response = await fetch("http://localhost:8080/api/webhooks", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(webhookDataToSend),
      });

      if (response.ok) {
        setWebhookData({ url: "" });
        alert("Webhook created successfully!");
      } else {
        alert("Failed to create webhook.");
      }
    } catch (error) {
      console.error("Error creating webhook:", error);
      alert("Error creating webhook.");
    }
  };

  return (
    <form onSubmit={handleSubmit} className={styles.formContainer}>
      <h2>Create Webhook</h2>
      <input
        type="url"
        placeholder="Webhook URL"
        value={webhookData.url}
        onChange={(e) =>
          setWebhookData({ ...webhookData, url: e.target.value })
        }
        className={styles.formInput}
        required
      />
      <button type="submit" className={styles.formButton}>
        Create Webhook
      </button>
    </form>
  );
};

export default WebhookForm;

