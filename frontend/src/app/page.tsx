import PaymentForm from "../forms/PaymentForm/PaymentForm";
import WebhookForm from "../forms/WebhookForm/WebhookForm";
import styles from "./page.module.css";

export default function Home() {
  return (
    <div className={styles.page}>
      <main className={styles.mainContent}>
        <PaymentForm />
        <WebhookForm />
      </main>
    </div>
  );
}
