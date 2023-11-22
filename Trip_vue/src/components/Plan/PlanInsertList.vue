<script setup>
import PlanInsertListItem from "@/components/Plan/PlanInsertListItem.vue";
import { usePlanStore } from "@/stores/planStore";
import { storeToRefs } from "pinia";
import { ref } from "vue";
</script>

<template>
  <div class="container">
    <p>추가한 리스트 목록</p>
    <div id="items">
      <PlanInsertListItem v-for="plan in plans" :p="plan"></PlanInsertListItem>
    </div>
  </div>
</template>

<style scoped></style>
