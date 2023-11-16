<script setup>
import PlanListItem from "@/components/Plan/PlanListItem.vue";
import { getMyPlans } from "@/api/trip.js";
import { ref, reactive } from "vue";
const items = ref([]);
const uid = ref(1);
function getItems() {
  getMyPlans(
    uid.value,
    (res) => {
      items.value = res.data;
    },
    (err) => {
      console.log(err);
    }
  );
}
getItems();
</script>
<template>
  <div>내 계획들 확인하는 뷰에용</div>
  <PlanListItem v-for="item in items" :item="item" :key="item.pid" />
</template>

<style scoped></style>
