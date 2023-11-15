<script setup>
import { ref } from "vue";
defineProps({ c: Object });
</script>

<template>
  <tr>
    <td>{{ c.num }}</td>
    <td>
      <RouterLink :to="{ name: 'detail', params: { num: c.num } }"> {{ c.name }}</RouterLink>
    </td>
  </tr>
</template>

<style scoped></style>
